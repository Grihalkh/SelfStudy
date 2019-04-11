#creating a graph using dictionary
graph = {}

graph['start'] = {}
graph['start']['a'] = 6
graph['start']['b'] = 2
# to get all vertices after start, use graph['start'].keys()
graph['a'] = {}
graph['a']['finish'] = 1
graph['b'] = {}
graph['b']['a'] = 3
graph['b']['finish'] = 5
graph['finish'] = {}

#creating costs table
inf = float('inf')
costs = {}
costs['a'] = 6
costs['b'] = 2
costs['finish'] = inf

#creating parents table to get the path after the algorithm is finished
parents = {}
parents['a'] = 'start'
parents['b'] = 'start'
parents['finish'] = None

#An array of processed elements
processed = []

#------------------------------------ Dijkstra's algorithm-----------------------------------------#
def find_lowest_cost_node(costs):
    lowest_cost = float('inf')
    lowest_cost_node = None
    for node in costs:
        cost = costs[node]
        if (cost < lowest_cost) and node not in processed:
            lowest_cost = cost
            lowest_cost_node = node
    return lowest_cost_node

node = find_lowest_cost_node(costs)
while node is not None:
    cost = costs[node]
    neighbours = graph[node]
    for n in neighbours.keys():
        new_cost = cost + neighbours[n]
        if costs[n] > new_cost:
            costs[n] = new_cost
            parents[n] = node
    processed.append(node)
    node = find_lowest_cost_node(costs)