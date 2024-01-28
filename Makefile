rebuild:
	docker cp target/testApp-0.0.1-SNAPSHOT.jar $$(docker ps -qf "name=template-app"):testApp-0.0.1-SNAPSHOT.jar && docker restart template-app