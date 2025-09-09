package br.com.familyfinance.financeapp.controller;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class HealthCheckControllerTest {

    @Test
    void testHealthMessage() {
        HealthCheckController controller = new HealthCheckController();
        String response = controller.health();
        assertThat(response).isEqualTo("API online 🚀");
    }
}
