package com.baangn.infra.presigner

import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.GetObjectRequest
import aws.sdk.kotlin.services.s3.model.PutObjectRequest
import aws.sdk.kotlin.services.s3.presigners.presignGetObject
import aws.sdk.kotlin.services.s3.presigners.presignPutObject
import com.baangn.config.AwsProperties
import org.springframework.stereotype.Component
import kotlin.time.Duration.Companion.hours

@Component
class PresignerUtils(
    private val s3: S3Client,
    private val properties: AwsProperties
) {
    companion object {
        const val bucketName = "test-bucket"
        const val PRODUCT_IMAGE_FOLDER = "product-image"
        const val PROFILE_IMAGE_FOLDER = "profile-image"
    }

    suspend fun getProductPresignedGetUrl(keyName: String): String {
        val unsignedRequest = GetObjectRequest {
            bucket = properties.bucket
            key = "$PRODUCT_IMAGE_FOLDER/$keyName"
        }

        val preSignedRequest = s3.presignGetObject(unsignedRequest, 24.hours)

        return preSignedRequest.url.toString()
    }

    suspend fun getProductPresignedPutUrl(keyName: String): String {
        val unsignedRequest = PutObjectRequest {
            bucket = properties.bucket
            key = "$PRODUCT_IMAGE_FOLDER/$keyName"
        }

        val preSignedRequest = s3.presignPutObject(unsignedRequest, 24.hours)

        return preSignedRequest.url.toString()
    }

    suspend fun getProfilePresignedGetUrl(keyName: String): String {
        val unsignedRequest = GetObjectRequest {
            bucket = properties.bucket
            key = "$PROFILE_IMAGE_FOLDER/$keyName"
        }

        val preSignedRequest = s3.presignGetObject(unsignedRequest, 24.hours)

        return preSignedRequest.url.toString()
    }

    suspend fun getProfilePresignedPutUrl(keyName: String): String {
        val unsignedRequest = PutObjectRequest {
            bucket = properties.bucket
            key = "$PROFILE_IMAGE_FOLDER/$keyName"
        }

        val preSignedRequest = s3.presignPutObject(unsignedRequest, 24.hours)

        return preSignedRequest.url.toString()
    }
}