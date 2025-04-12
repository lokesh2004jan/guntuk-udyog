package com.example.guntuk.udyog.controller;


import com.example.guntuk.udyog.model.ContactMessage;
import com.example.guntuk.udyog.service.ContactMessageService;
import com.example.guntuk.udyog.service.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactMessageService contactMessageService;
    @Autowired
    private emailService emailService;

    @PostMapping("/add")
    public ResponseEntity<Object> submitMessage(@RequestBody ContactMessage contactMessage) {
        System.out.println(contactMessage);
        contactMessageService.saveContactMessage(contactMessage);





        String mail = contactMessage.getEmail();
        String name = contactMessage.getName();

        String subject = "Thank You for Visiting Guntuk – మీ పట్టు ప్రయాణం ప్రారంభమైంది!";
        String htmlBody = getBeautifulHtmlContent(name);

        // ✅ Sends HTML email
        emailService.sendEmail(mail, subject, htmlBody);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Message submitted successfully");


        return ResponseEntity.ok(response);
    }

    public String getBeautifulHtmlContent(String name) {
        return """
    <html>
    <body style='font-family:Segoe UI, sans-serif;background:#f9f9f9;padding:20px;color:#333'>
    <div style='background:white;padding:25px;border-radius:10px;max-width:600px;margin:auto;box-shadow:0 2px 8px rgba(0,0,0,0.1)'>
      <h2 style='color:#aa3d00'>Hi %s,</h2>
      <p>Thank you for visiting the <b>Guntuk</b> app and exploring our premium textile products.</p>
      <p>We’ve received your message and our team will reach out to assist you shortly.</p>
      <h3>🌟 Why Choose Guntuk?</h3>
      <ul>
        <li>✓ Premium silk fabrics</li>
        <li>✓ Elegant & timeless designs</li>
        <li>✓ Trusted by thousands of happy customers</li>
      </ul>
      <p>We’re honored to be part of your journey in tradition and elegance!</p>
      <hr style='margin:30px 0' />
      <h2>హాయ్ %s గారు,</h2>
      <p>మీరు గుంటుక్ యాప్‌ను సందర్శించి మా నాణ్యమైన పట్టు ఉత్పత్తులను పరిశీలించినందుకు మేము చాలా సంతోషంగా ఉన్నాము.</p>
      <p>మీ సందేశం అందింది. మా బృందం త్వరలోనే మిమ్మల్ని సంప్రదిస్తుంది.</p>
      <h3>🌟 గుంటుక్ ఎందుకు ప్రత్యేకం?</h3>
      <ul>
        <li>✓ ఉత్తమమైన సిల్క్ ఫ్యాబ్రిక్స్</li>
        <li>✓ ఆహ్లాదకరమైన మరియు శాశ్వతమైన డిజైన్‌లు</li>
        <li>✓ వేలాది మంది సంతృప్తి చెందిన కస్టమర్ల విశ్వాసం</li>
      </ul>
      <p>With gratitude,<br/>
      <b>Guntuk Team</b><br/>
      <a href="https://guntuktextiles.com">guntuktextiles.com</a>
      </p>
    </div>
    </body>
    </html>
    """.formatted(name, name);
    }


    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("API is working!");
    }

    @GetMapping("/showAll")
    public List<ContactMessage> showAll() {
       return contactMessageService.ShowAll();
    }


}
