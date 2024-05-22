package com.forza.apirest.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);

		// Prueba de conexión a la base de datos MySQL
		try {
			// Conexión a la base de datos
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/login_schema", // URL de la base de datos corregida
					"root", // Usuario de la base de datos
					"password" // Contraseña de la base de datos
			);

			// Crear un objeto Statement
			Statement statement = connection.createStatement();

			// Ejecutar una consulta SQL
			ResultSet resultSet = statement.executeQuery("SELECT * FROM USUARIO");

			// Iterar sobre el ResultSet
			while (resultSet.next()) {
				// Imprimir los datos obtenidos
				System.out.println("Username: " + resultSet.getString("username"));
				System.out.println("Password: " + resultSet.getString("password"));
			}

			// Cerrar recursos
//			resultSet.close();
//			statement.close();
//			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


