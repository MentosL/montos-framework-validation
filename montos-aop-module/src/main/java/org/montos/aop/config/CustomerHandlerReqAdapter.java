package org.montos.aop.config;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * @author : MentosL
 * @date : 2023/4/15 23:00
 */
public class CustomerHandlerReqAdapter extends RequestBodyAdviceAdapter {
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return (AbstractJackson2HttpMessageConverter.class.isAssignableFrom(converterType) &&
                methodParameter.getParameterAnnotation(RequestBody.class) != null);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        InputStream body = inputMessage.getBody();
        if (body.available() >0){
            String bodyStr = convertInputStreamToString(body);
            return new CustomerHttpInputMessage(new ByteArrayInputStream(Base64.decode(bodyStr)),inputMessage.getHeaders());
        }else {
            return super.beforeBodyRead(inputMessage,parameter,targetType,converterType);
        }
    }

    private  String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }

        bufferedReader.close();
        return stringBuilder.toString();
    }

    static class CustomerHttpInputMessage implements HttpInputMessage{

        private final InputStream body;

        private final HttpHeaders headers;


        public CustomerHttpInputMessage(InputStream body, HttpHeaders headers) {
            this.body = body;
            this.headers = headers;
        }

        @Override
        public InputStream getBody() throws IOException {
            return this.body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return this.headers;
        }
    }
}
