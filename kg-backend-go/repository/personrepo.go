package repo

import (
	"fmt"

	gremlingo "github.com/apache/tinkerpop/gremlin-go/driver"
)

func GetAllPersons() interface{} {
	remote, err := gremlingo.NewDriverRemoteConnection("ws://localhost:8182/gremlin")
	if err != nil {
		panic(err.Error())
	}
	g := gremlingo.Traversal_().WithRemote(remote)

	result, err := g.V().HasLabel("person").FlatMap().ToList()
	if err != nil {
		panic(err.Error())
	}
	fmt.Println("Persons:", result)

	return result
}
