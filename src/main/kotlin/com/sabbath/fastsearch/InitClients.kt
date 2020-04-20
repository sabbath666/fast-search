package com.sabbath.fastsearch

import com.sabbath.fastsearch.jpa.Client
import com.sabbath.fastsearch.jpa.ClientRepository
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import com.github.javafaker.Faker
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.client.transport.TransportClient
import java.util.*

@Component
class InitClients(
        val clientRepository: ClientRepository,
        val restClient: RestHighLevelClient
) {

    @PostConstruct
    fun init() {
        val faker = Faker.instance(Locale.forLanguageTag("ru"))
        repeat(10) {
            clientRepository.save(
                    Client(firstname = faker.name().firstName(), lastname = faker.name().lastName(), birthdate = faker.date().birthday())
            )
        }

        clientRepository.save(Client(firstname = "Сергей", lastname = "Задорожный", birthdate = faker.date().birthday()))

    }
}