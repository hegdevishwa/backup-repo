package com.vishwa.couchbase;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;
import com.couchbase.client.java.view.ViewRow;

public class Test1 {

	public static void main(String[] args) {
		// Connect to localhost
		Cluster cluster = CouchbaseCluster.create();
		// Open the default bucket and the "beer-sample" one
		Bucket bucket = cluster.openBucket();
		// Disconnect and clear all allocated resources
		Test1 test = new Test1();
		// test.save(defaultBucket);
		test.queryView(bucket);
	}

	public void save(Bucket bucket) {

		for (int i = 1; i < 100000; i++) {
			JsonObject productJson = JsonObject.empty().put("name", "An ice sculpture " + i).put("price", i + 10)
					.put("length", 7.0).put("width", 12.0).put("height", 9.5).put("color", getRandomColor())
					.put("description", "This product is not for sale");
			// Store Document to Couchbase with a “productKey”x`
			JsonDocument productJsonToBeStored = JsonDocument.create(Integer.toString(i), productJson);
			bucket.upsert(productJsonToBeStored);
		}

		// JsonDocument productRecievedFromDB =
		// testSampleBucket.upsert(productJsonToBeStored);
	}

	public String getRandomColor() {

		List<String> list = Arrays.asList("RED", "GREEN", "BLUE", "YELLOW");

		Random random = new Random();
		return list.get(random.nextInt(4));

	}

	public void queryView(Bucket bucket) {

		ViewResult result = bucket.query(ViewQuery.from("_design/test_vw/_views", "price_vw"));
		for (ViewRow row : result.allRows()) {
			JsonDocument doc = row.document();
			System.out.println(doc.content().toString());

		}

	}
}
