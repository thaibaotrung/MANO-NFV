package org.example;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class Turnoff {
    public static void main(String[] args) {
        Config config = new ConfigBuilder()
                .withMasterUrl("https://127.0.0.1:60628")
                .withTrustCerts(true)
                .build();

        try (KubernetesClient client = new DefaultKubernetesClient(config)) {
            client.apps().deployments().inNamespace("default").withName("reddit-deployment").delete();
            System.out.println("Pod đã được tắt.");
        }
    }
}