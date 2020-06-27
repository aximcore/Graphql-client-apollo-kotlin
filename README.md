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
## second write .graphql files
Examples: 
- https://graphql.org/learn/queries/
- src/main/graphql/*.graphql

## third generate graphql models
gradle Tasks -> apollo -> generateApolloSources

