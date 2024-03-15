package org.example;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class Healing {
    public static void main(String[] args) {
        Config config = new ConfigBuilder()
                .withMasterUrl("https://127.0.0.1:60628")
                .withTrustCerts(true)
                .build();

        try (KubernetesClient client = new DefaultKubernetesClient(config)) {
            // Tắt pod có tên "reddit-deployment-86f8c7bb87-9jtbs" trong namespace "default"
            client.pods().inNamespace("default").withName("reddit-deployment-86f8c7bb87-j24qv").delete();
            System.out.println("Pod đã được tắt.");
        }
    }
}