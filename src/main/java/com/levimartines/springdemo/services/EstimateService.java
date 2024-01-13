package com.levimartines.springdemo.services;

import com.levimartines.springdemo.entities.Estimate;
import com.levimartines.springdemo.repositories.EstimateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class EstimateService {

	private final EstimateRepository estimateRepository;
	private final TemplateEngine templateEngine;

	public byte[] generateEstimatePdf(Long id) {
		Optional<Estimate> optional = estimateRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		try {
			return generateEstimatePdf(optional.get());
		} catch (Exception e) {
			log.error("Error trying to generate estimate pdf", e);
			return null;
		}
	}

	private byte[] generateEstimatePdf(Estimate estimate) throws Exception {
		// Prepare Thymeleaf context
		Context context = new Context();
		context.setVariable("estimate", estimate);
		context.setVariable("items", estimate.getItems());
		context.setVariable("total", estimate.getTotal());
		context.setVariable("car", estimate.getCar());
		context.setVariable("client", estimate.getCar().getCustomer());

		// Process Thymeleaf template
		String html = templateEngine.process("estimate-template.xhtml", context);

		// Generate PDF from HTML using Flying Saucer
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			ITextRenderer renderer = new ITextRenderer();
			SharedContext sharedContext = renderer.getSharedContext();
			sharedContext.setPrint(true);
			sharedContext.setInteractive(false);
			renderer.setDocumentFromString(html);
			renderer.layout();
			renderer.createPDF(outputStream);
			return outputStream.toByteArray();
		}
	}

}
