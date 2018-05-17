package bug;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;


/**
 * Property of CODIX Bulgaria EAD
 * Date: 3/6/2018 Time: 6:49 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author vtodorov
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Docs.class)
public class DocsTest
{

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(
                        documentationConfiguration(this.restDocumentation)
                                .operationPreprocessors()
                                .withResponseDefaults(prettyPrint())
                ).build();
    }


    @Test
    public void bug() throws Exception
    {
        mockMvc.perform(
                get("/bug")
        )
                .andDo(MockMvcResultHandlers.print())
                .andDo(
                        document(
                                "bug"
                                , responseFields(
                                        fieldWithPath("alertStatus").description("Object").type(String.class)
                                        , fieldWithPath("alertStatus.alertStatusFlag").description("Part of an object")
                                        , fieldWithPath("alertStatus.alertStatusDetail").description("Another part of an object")
                                        ,
                                        fieldWithPath("listName[]").description("Array")
                                        , fieldWithPath("listName[].k1").description("This used to work like charm in V1...").optional()
                                        , fieldWithPath("listName[].k2").description("And now in V2 it is not ...")
                                        , fieldWithPath("listName[].i").description("int item ")
                                )
                        )
                );

    }
}
