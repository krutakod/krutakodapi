package krutakod.company.krutakodserver.googleservice;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.androidpublisher.AndroidPublisher;
import com.google.api.services.androidpublisher.AndroidPublisherScopes;
import com.google.api.services.androidpublisher.model.ProductPurchase;
import com.google.api.services.androidpublisher.model.SubscriptionPurchase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GooglePlayService {
    private final Map<String, AndroidPublisher> androidPublishers = new HashMap<>();


    public String readCredentialsJson(String packageName) {
        // здесь надо прочитать данные из JSON-файла и вернуть их
//        StringBuffer stringBuffer = new StringBuffer();
//
//        try {
//            Files.lines(Paths.get("api-4800674348163538658-947350-9cbda935128f.json"),
//                    StandardCharsets.UTF_8).forEach(stringBuffer::append);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"api-4800674348163538658-947350\",\n" +
                "  \"private_key_id\": \"9cbda935128f9840b1af41ba01249d85eaa0ab61\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCa1nJRce49Jcg7\\n3fCE03XsUMBpXvRbbMkDV5BYYlAACn6BRIgB33NKPlREpD0y1dKZb45oT2cfgNDe\\nPT19h+G9WQPh37EtTbXTH6xryySmYYvbGyzyjYKlsLLqQ17wFItRb6yzclNY/AKs\\nBnQafUYgcB/tEk9TanKor8+pmGxk+YjM6aLBYSKT32bFafI4j8iOu2k4aDA7YTaA\\n62CTJgOPCZxzX+Bh9awZE2YYEwNNIdhXjb7jKExS770l4QSu0RrjTmzLqPkv7vS0\\nSxZ0zaRcKjrQ2QipXLOEhAsLHaI2lShJQUU8rJ73gIaE/Oqlmyx5Juni9mpkvGdz\\nKrZnJ8CZAgMBAAECggEABt5t4oW8BzkT3EQI6tDkBwBraMFDny1WRYWu65zWO7Tm\\nI8nsgVjDqTmBTNeUYhrw5XROIaZ+xqZU8xGjFrHee83lHty+OWpHH1SPtkB5dxVr\\nZORHEYOMQNlz4RyYAO0zDlZ2l4dXgeJmzpwtWQzRqEK7x9frbkyR8EB3D+j+dgQ3\\nh5AFcVLqAZCq7zgZglJe90E1Vmt48IRrL25sZ049OJOZjuus9P8seibgrTNqLpJD\\nqK29IWa4HNHHhcs9peb30+MEXVCgF2Homd5GbLvzLU0Su266stMBPNHSVC9I70eq\\n4VJcgGOgliJt/rjb2fTuvvaad3YRVqyt6ceyzNgC2QKBgQDSgzCCDyttuu8gVhUY\\n8mmP8z0xco02afpG/R/S414Ej8KaFhcfPnZkSN280jYUBdCWeaVeh8d+ZWqyIhvi\\n0+sf4HclAVirZsrOr3D3DftA/16/qEzjot5cFk1T3TuRqNa+w9NO8QDmwBcMr96Z\\nWLUEF35HKod/h+jnoEgkopZNewKBgQC8S4YV8922VNuvdoT6o3ADg9IcGSQdzaSZ\\nWnHP/DapdH3xS4GWwVXxHGcxC0UvcPTmCEj1TSBzcyKgzSsloPa8AdPLfReIT6C3\\nRIaBSWEKychd8Fu0LjPIzL+RBbTD9NSWZmJayUgxOPdY+axii7MzfD/YBCuxF9H6\\n4bZQy6iL+wKBgHnktOXaWs9C+svCjJzRYQaVVc2YAuSLIPyR/SdjuEDz7T7Do8fX\\npz4SYzK+lcmqREmdToAaJw2tM8bJsVP6WZ8vnk2zJeC5uJ1NQSAM3HuaYwafMUZu\\nPEseLtBsvd1t4kq7oVOIgXkbqT0TaNVqZAZmhBw5KBRUYiwcxylPa7CZAoGBAIRj\\nHU1F/rZ5h1QgonKOgu0Vu55h1tDVi0r/GlI/ZDdUXlBO5DgYitJRRARphiVK6ATs\\nAk/mAFDrvIcOea2lNJUPO9gwhWEjiz4PgfpYm1A4exYBLpjKe0JNIstWFbhI5Ucx\\niSmHp6hkAxSdxqQq0L38N+8rT4Td2JbqJ4M7DbANAoGBAKUm6vWQyIfb2di/+0qU\\nZjJY8NNMg5qR6b+Ckdpzl+MF2iQH82JJvqb+KzNX1sCkPUWed869CTAWxddV+kwe\\nDqFBm7IuX3Jw0NmcFYwxHx6GLVdDpqzjYwFKAVvEbV05THGW+0Rvef20MEX26cNW\\nIZub9LfQ8lr2YPzTceXliuAy\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"krutakodserver@api-4800674348163538658-947350.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"109329384230100450152\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/krutakodserver%40api-4800674348163538658-947350.iam.gserviceaccount.com\"\n" +
                "}";
    }

    private AndroidPublisher getPublisher(String packageName) throws Exception {
        if (!androidPublishers.containsKey(packageName)) {
            String credentialsJson = readCredentialsJson(packageName);
            InputStream inputStream = new ByteArrayInputStream(
                    credentialsJson.getBytes(StandardCharsets.UTF_8));
            HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
            GoogleCredential credential = GoogleCredential.fromStream(inputStream)
                    .createScoped(Collections.singleton(
                            AndroidPublisherScopes.ANDROIDPUBLISHER));
            AndroidPublisher.Builder builder = new AndroidPublisher.Builder(
                    transport, JacksonFactory.getDefaultInstance(), credential);
            AndroidPublisher androidPublisher = builder.build();
            androidPublishers.put(packageName, androidPublisher);
        }
        return androidPublishers.get(packageName);
    }

    public ProductPurchase getPurchase(String packageName,
                                       String productId,
                                       String token)
            throws Exception {
        AndroidPublisher publisher = getPublisher(packageName);
        AndroidPublisher.Purchases.Products.Get get = publisher
                .purchases().products().get(packageName, productId, token);
        return get.execute();
    }

    public SubscriptionPurchase getSubscription(String packageName,
                                                String productId,
                                                String token)
            throws Exception {
        AndroidPublisher publisher = getPublisher(packageName);
        AndroidPublisher.Purchases.Subscriptions.Get get = publisher
                .purchases().subscriptions().get(packageName, productId, token);
        return get.execute();
    }
}
