package org.example;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class GetPod {
    public static void main(String[] args) {
        // Thiết lập cấu hình kết nối
        Config config = new ConfigBuilder()
                .withMasterUrl("https://127.0.0.1:60628")
                .withTrustCerts(true)
                .build();

        // Tạo client Kubernetes
        try (KubernetesClient client = new DefaultKubernetesClient(config)) {
            // Các hoạt động trên cluster Kubernetes
            // Ví dụ: Lấy danh sách các pods trong namespace kube-system
            client.pods().inNamespace("default").list().getItems().forEach(pod -> {
                System.out.println("Pod: " + pod.getMetadata().getName());
            });
        }
    }
}