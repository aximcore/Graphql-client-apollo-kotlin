## first download scheme.json 

```
 ./gradlew downloadApolloSchema \
  --endpoint="https://your.domain/graphql/endpoint" \
  --schema="src/main/graphql/schema.json"
```

Or requires auth:

```
./gradlew downloadApolloSchema \
  --endpoint="https://your.domain/graphql/endpoint" \
  --schema="src/main/graphql/schema.json" \
  --header="Authorization: Bearer $TOKEN"
```

## second generate graphql models
gradle Tasks -> apollo -> generateApolloSources

