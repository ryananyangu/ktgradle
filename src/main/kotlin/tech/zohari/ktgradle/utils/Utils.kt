package tech.zohari.ktgradle.utils

import java.nio.charset.StandardCharsets
import org.apache.http.client.methods.HttpPost
import org.apache.http.conn.ssl.NoopHostnameVerifier
import org.apache.http.conn.ssl.TrustAllStrategy
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.BasicResponseHandler
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.ssl.SSLContextBuilder

fun SendPost(
        url: String,
        payload: String,
        headers: HashMap<String, String>
): HashMap<String, String> {

    var response = HashMap<String, String>()

    val httpclient =
            HttpClientBuilder.create()
                    .setSSLContext(
                            SSLContextBuilder()
                                    .loadTrustMaterial(null, TrustAllStrategy.INSTANCE)
                                    .build()
                    )
                    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                    .build()
    val httppost = HttpPost(url)

    val entity = StringEntity(payload, StandardCharsets.UTF_8)

    for ((k, v) in headers) {
        httppost.addHeader(k, v)
    }

    httppost.setEntity(entity)

    val responseHandler = BasicResponseHandler()
    val responseBody = httpclient.execute(httppost)
    val body = responseHandler.handleResponse(responseBody)
    val status = responseBody.getStatusLine().getStatusCode()
    response.put("Status", "" + status)
    response.put("Body", body)

    return response
}
