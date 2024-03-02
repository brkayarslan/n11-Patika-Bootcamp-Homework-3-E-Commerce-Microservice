package com.berkayarslan.UserEngage;

import com.berkayarslan.UserEngage.general.RestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

public class BaseControllerTest {

    protected ObjectMapper objectMapper;

    protected boolean isSuccess(MvcResult mvcResult) throws UnsupportedEncodingException, JsonProcessingException {
        MockHttpServletResponse response = mvcResult.getResponse();
        String content = response.getContentAsString();

        RestResponse restResponse = objectMapper.readValue(content,RestResponse.class);

        boolean success = restResponse.isSuccess();
        return success;
    }
}
