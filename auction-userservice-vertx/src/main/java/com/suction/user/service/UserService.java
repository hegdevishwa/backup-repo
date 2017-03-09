package com.suction.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.suction.user.model.User;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLConnection;

public class UserService {

	JDBCClient jdbc;

	Logger logger = (Logger) LogManager.getRootLogger();

	public UserService(JDBCClient jdbc) {

		super();
		System.out.println(">>>>>>>>>> Creating user service");
		this.jdbc = jdbc;
	}

	public void getUser(String userName, Handler<AsyncResult<User>> handler) {
		jdbc.getConnection(asyncResult -> {
			if (asyncResult.failed()) {
				asyncResult.cause().printStackTrace();
			} else {
				SQLConnection connection = asyncResult.result();
				System.out.println(">>>>>>>>>>>>>>> userName: " + userName);
				connection.queryWithParams("select * from user where username = ?",
						new JsonArray().add(userName.toLowerCase()), queryResult -> {

							if (queryResult.failed()) {
								queryResult.cause().printStackTrace();
								return;
							} else {
								if (queryResult.result().getNumRows() <= 0) {
									handler.handle(Future.failedFuture("No user found"));
								} else {
									handler.handle(
											Future.succeededFuture(new User(queryResult.result().getRows().get(0))));
								}
							}

						});
			}
		});
	}

}
