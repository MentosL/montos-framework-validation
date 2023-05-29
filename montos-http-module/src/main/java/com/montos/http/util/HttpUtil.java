package com.montos.http.util;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Map;

public class HttpUtil {

    /**
     * 生成post请求的JSON请求参数 请求示例: { "id":1, "name":"哈哈" }
     *
     * @return
     */
    public static HttpEntity<Map<String, String>> generatePostJson(Map<String, String> jsonMap) {

        // 如果需要其它的请求头信息、都可以在这里追加
        HttpHeaders httpHeaders = new HttpHeaders();

        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");

        httpHeaders.setContentType(type);

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(jsonMap, httpHeaders);

        return httpEntity;
    }

    /**
     * 生成get参数请求url 示例：https://0.0.0.0:80/api?u=u&o=o 示例：https://0.0.0.0:80/api
     *
     * @param uri 请求的uri 示例: 0.0.0.0:80
     * @param params 请求参数
     * @return
     */
    public static String generateRequestParameters(String uri, Map<String, String> params) {
        StringBuilder sb = new StringBuilder(uri);
        if (params != null && !params.isEmpty()) {
            sb.append("?");
            for (Map.Entry map : params.entrySet()) {
                sb.append(map.getKey()).append("=").append(map.getValue()).append("&");
            }
            uri = sb.substring(0, sb.length() - 1);
            return uri;
        }
        return sb.toString();
    }
}
