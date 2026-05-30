package com.example.tp3parcial.api.user

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val api: UserApi  // Hilt injects this automatically
) {
    suspend fun getUsers(): Result<List<User>> = runCatching {
        api.getUsers().map { it.toDomain() }
    }
}