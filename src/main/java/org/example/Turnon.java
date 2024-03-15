package org.example;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.*;


public class Turnon {
    public static void main(String[] args) {
        Config config = new ConfigBuilder()
                .withMasterUrl("https://127.0.0.1:60628")
                .withTrustCerts(true)
                .build();
        try (KubernetesClient client = new DefaultKubernetesClient(config)) {
            // Load Deployment YAML Manifest into Java object
            Deployment deploy1 = client.apps().deployments()
                    .load(Turnon.class.getResourceAsStream("/Deployment.yaml"))
                    .item();
            // Apply it to Kubernetes Cluster
            client.apps().deployments().inNamespace("default").resource(deploy1).create();
            System.out.println("Đã bật VNF thành công");
        }
    }
}