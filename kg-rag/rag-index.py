from langchain_community.vectorstores import Neo4jVector
from langchain_huggingface import HuggingFaceEmbeddings # Add this import


# Create the vectorstore for our existing graph
Neo4jVector.from_existing_graph(
    embedding=HuggingFaceEmbeddings(model_name="sentence-transformers/all-MiniLM-L6-v2"),  # Use MiniLM
    url="bolt://localhost:7687",
    username="neo4j",
    password="11111111",
    index_name="product_index",
    node_label="Product",
    text_node_properties=["name", "description","category"],
    embedding_node_property="embedding",
)
Neo4jVector.from_existing_graph(
    embedding=HuggingFaceEmbeddings(model_name="sentence-transformers/all-MiniLM-L6-v2"),  # Use MiniLM
    url="bolt://localhost:7687",
    username="neo4j",
    password="11111111",
    index_name="product_index",
    node_label="Product",
    text_node_properties=["name", "description","category"],
    embedding_node_property="embedding",
)
Neo4jVector.from_existing_graph(
    embedding=HuggingFaceEmbeddings(model_name="sentence-transformers/all-MiniLM-L6-v2"),  # Use MiniLM
    url="bolt://localhost:7687",
    username="neo4j",
    password="11111111",
    index_name="product_index",
    node_label="Person",
    text_node_properties=["name", "role"],
    embedding_node_property="embedding",
)