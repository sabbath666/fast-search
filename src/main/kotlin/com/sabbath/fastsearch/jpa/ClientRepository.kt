package com.sabbath.fastsearch.jpa

import com.sabbath.fastsearch.jpa.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<Client, Long> {
}