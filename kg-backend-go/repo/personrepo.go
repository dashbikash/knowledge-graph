package repo

import (
	"fmt"

	gremlingo "github.com/apache/tinkerpop/gremlin-go/driver"
)

func AddPersons() {
	remote, err := gremlingo.NewDriverRemoteConnection("ws://localhost:8182/gremlin")
	if err != nil {
		panic(err.Error())
	}
	g := gremlingo.Traversal_().WithRemote(remote)

	g.AddV("person").Property("uid", "bikash").Property("name", "Bikash Dash").Iterate()
	g.AddV("person").Property("uid", "puspa").Property("name", "Puspa Dash").Iterate()
	g.AddV("person").Property("uid", "pragyan").Property("name", "Pragyan Dash").Iterate()

	fmt.Println(g.V().HasLabel("person").ValueMap().ToList())

}
