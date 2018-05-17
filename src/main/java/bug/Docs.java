package bug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@EnableAutoConfiguration
@RestController
public class Docs
{
    @GetMapping("/bug")
    public ResponseEntity bug()
    {
        return
                ResponseEntity.ok(
                        new Object()
                        {
                            public Object alertStatus = new Object()
                            {
                                public String alertStatusFlag = "PF";
                                public String alertStatusDetail = "Free to process";
                            };

                            public List listName = Arrays.asList(
                                    new Object()
                                    {
                                        public String k1 = "";
                                        public String k2 = "v2";
                                        public Integer i = 1;
                                    }
                                    , new Object()
                                    {
                                        public String k1 = null;//"1";
                                        public String k2 = "v4";
                                        public Integer i = 1;
                                    }
                            );
                        }
                );
    }


    public static void main(String[] args)
    {
        SpringApplication.run(Docs.class, args);
    }
}
