package com.backend.gini.web;

//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

//    @Autowired
//    private MockMvc mock;
//    /**
//     * 테스트 코드 작성법
//     * */
//    @Test
//    public void hello가_리턴된다() throws Exception {
//        String hello = "Hello word!";
//        mock.perform(get("/api/hello"))
//        .andExpect(status().isOk())
//        .andExpect(content().string(hello));
//    }
}
