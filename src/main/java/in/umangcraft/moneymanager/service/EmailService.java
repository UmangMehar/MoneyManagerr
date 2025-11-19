package in.umangcraft.moneymanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    @Value("${brevo.api.key}")
    private String apiKey;

    @Value("${brevo.from.email}")
    private String fromEmail;

    @Value("${brevo.from.name}")
    private String fromName;

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.brevo.com/v3/smtp/email")
            .defaultHeader("accept", "application/json")
            .build();

    public void sendEmail(String to, String subject, String body) {
        try {
            Map<String, Object> payload = Map.of(
                    "sender", Map.of("name", fromName, "email", fromEmail),
                    "to", List.of(Map.of("email", to)),
                    "subject", subject,
                    "htmlContent", "<html><body>" + body + "</body></html>"
            );

            String response = webClient.post()
                    .header("api-key", apiKey)  // ✅ Brevo API authentication
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(payload)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block(); // sync call

            log.info("✅ Email sent successfully to {} | Response: {}", to, response);

        } catch (Exception e) {
            log.error("❌ Failed to send email via Brevo API", e);
            throw new RuntimeException("Failed to send email via Brevo API: " + e.getMessage(), e);
        }
    }
}
