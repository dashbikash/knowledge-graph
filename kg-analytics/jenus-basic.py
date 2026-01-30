from gremlin_python.process.anonymous_traversal import traversal

from gremlin_python.driver.driver_remote_connection import DriverRemoteConnection

g = traversal().withRemote(DriverRemoteConnection('ws://localhost:8182/gremlin','g'))

g.addV('person').property('uid','bikash').property('name', 'Bikash Dash').iterate()
g.addV('person').property('uid','puspa').property('name', 'Puspa Dash').iterate()
g.addV('person').property('uid','pragyan').property('name', 'Pragyan Dash').iterate()

print(g.V().hasLabel('person').valueMap().toList())