from langchain_community.vectorstores import Neo4jVector
from langchain_huggingface import HuggingFaceEmbeddings  # Add this import

product_graph = Neo4jVector.from_existing_index(
    embedding=HuggingFaceEmbeddings(model_name="sentence-transformers/all-MiniLM-L6-v2"), 
    url="bolt://localhost:7687",
    username="neo4j",
    password="11111111",
    index_name="product_index",
    text_node_property="name",
)

from pprint import pprint
print("=========RESULTS===========")
result = product_graph.similarity_search("what are employees of CRM System")
for doc in result:
    print(doc)
