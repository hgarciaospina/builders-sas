package com.builderssas.api.config;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.spi.ConnectionFactory;

/**
 * ✅ Configuración central para R2DBC (PostgreSQL no bloqueante)
 *
 * Esta clase:
 * 1. Crea un ConnectionPool no bloqueante usando R2DBC.
 * 2. Habilita los repositorios reactivos en el paquete com.builderssas.api.repository.
 * 3. (Opcional) Inicializa el esquema desde un script SQL en resources/schema.sql si existe.
 */
@Configuration
@EnableR2dbcRepositories(basePackages = "com.builderssas.api.repository")
public class R2dbcConfig {

    /**
     * Crea la configuración base para conectar a PostgreSQL de forma reactiva.
     * Ajusta los valores según tu entorno local.
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder()
                .host("localhost")
                .port(5432)
                .database("builders_sas_db")
                .username("postgres")
                .password("Leandro2009*") // 🔒
                .build();

        PostgresqlConnectionFactory factory = new PostgresqlConnectionFactory(config);

        ConnectionPoolConfiguration poolConfig = ConnectionPoolConfiguration.builder(factory)
                .maxIdleTime(java.time.Duration.ofMinutes(30))
                .initialSize(5)
                .maxSize(20)
                .build();

        return new ConnectionPool(poolConfig);
    }

    /**
     * (Opcional) Inicializa la base de datos ejecutando un script SQL.
     * Se ejecuta automáticamente al iniciar la aplicación si existe /resources/schema.sql.
     */

    /*
    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        // Solo si se tiene un archivo schema.sql en resources
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        return initializer;
    }
     */
}
