package victorteka.github.io.tmdbapp.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import victorteka.github.io.tmdbapp.BuildConfig
import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.api.ApiHelperImpl
import victorteka.github.io.tmdbapp.data.api.ApiService
import victorteka.github.io.tmdbapp.utils.CacheInterceptor
import victorteka.github.io.tmdbapp.utils.Constants
import victorteka.github.io.tmdbapp.utils.ForceCacheInterceptor
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideBaseURL() = Constants.BASE_URL

    /*@Provides
    @Singleton
    fun provideApiKey() = Constants.API_KEY*/

    @Provides
    @Singleton
    /*fun provideOkHttpClient() = OkHttpClient
        .Builder()
        .addNetworkInterceptor(CacheInterceptor())
        .addInterceptor(ForceCacheInterceptor())
        .build()*/
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper
}