package ru.itmo.hls.cronservice.service

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class OrderCancellationScheduler(
    private val rabbitTemplate: RabbitTemplate
) {

    private val log = LoggerFactory.getLogger(OrderCancellationScheduler::class.java)

    data class OrderCancelCheckCommand(val requestedAt: String = java.time.Instant.now().toString())

    @Scheduled(fixedDelayString = "\${cron.order-cancel.interval-ms:60000}")
    fun triggerCancelCheck() {
        val payload = OrderCancelCheckCommand()
        rabbitTemplate.convertAndSend("hls.commands", "order.check-cancel", payload)
        log.info("Sent order cancel check command")
    }
}
