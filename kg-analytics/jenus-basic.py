from gremlin_python import statics
from gremlin_python.structure.graph import Graph
from gremlin_python.process.graph_traversal import __
from gremlin_python.driver.driver_remote_connection import DriverRemoteConnection

from gremlin_python.process.anonymous_traversal import traversal

try:
    connection = DriverRemoteConnection('ws://localhost:8182/gremlin', 'g')
    g = traversal().withRemote(connection)
    
    user_node = g.addV('User').property('name', 'Alice').property('age', 30).next()
    
    
    
    # Query the data
    print('\nUsers in graph:')
    users = g.V().hasLabel('User').valueMap().toList()
    print(users)
    
except Exception as e:
    print(e)
    print("Make sure Gremlin server is running on ws://localhost:8182/gremlin")
    
finally:
    try:
        connection.close()
    except:
        pass