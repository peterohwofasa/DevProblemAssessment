package com.example.service.web;

import com.example.DemoApplication;
import com.example.repo.ClientRepository;
import com.example.web.rest.ClientResource;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Transactional
public class ClientResourceTests {

    @Autowired
    private ClientRepository clientRepository;
    private MockMvc restMvc;
    private MockMvc restUserMockMvc;
    private Object exceptionTranslator = new Object();

    @Before
    public void setup(){


    }
}
