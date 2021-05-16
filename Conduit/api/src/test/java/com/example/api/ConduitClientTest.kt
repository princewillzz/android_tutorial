package com.example.api

import com.example.api.models.entities.UserCreds
import com.example.api.models.requests.SignupRequest
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.util.*
import kotlin.random.Random

class ConduitClientTest {

    private val conduitClient = ConduitClient()

    @Test
    fun `Get articles`() {
        runBlocking {
            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }

//        val articles = conduitClient.api.getArticles().execute()
//        assertNotNull(articles.body()?.articles)

    }

    @Test
    fun `Get articles by author`() {
        runBlocking {
            val articles = conduitClient.api.getArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }

    }

    @Test
    fun `Get articles by tags`() {
        runBlocking {
            val articles = conduitClient.api.getArticles(tag = "dragons")
            assertNotNull(articles.body()?.articles)
        }

    }

    @Test
    fun `POST users - create user`() {
        val userCreds = UserCreds(
            email="testEmail${Random.nextInt(999, 9999)}@test.com",
            password = "pass${Random.nextInt(9999, 9999999)}",
            username = "rand_user_${Random.nextInt(999, 9999)}"
        )
        runBlocking {
            val resp = conduitClient.api.signupUser(SignupRequest(userCreds))

            assertEquals(userCreds.username, resp.body()?.user?.username)
        }
    }



}