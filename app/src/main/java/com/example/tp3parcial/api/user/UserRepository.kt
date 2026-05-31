package com.example.tp3parcial.api.user

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val api: UserApi
) {
    suspend fun getUser(id: Int): Result<User> = runCatching {
        api.getUser(id).user.toDomain()
    }
}