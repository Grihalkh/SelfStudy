from structures import ConList, Stack, Queue

# lst = ConList()
# lst.insert(1)
# lst.insert(2)
# lst.insert(3)
# print(lst.pop())
# lst.insert(4)
# print(lst)
# print(lst.nodes)

# stack = Stack()
# stack.push(4)
# stack.push(5)
# stack.push(6)
# print(stack.pop())
# stack.push(7)
# print(stack)
# print(stack.count)

print('Stack:')
stack = Stack([1, 2, 3])
print(stack)
print(stack.peek())
stack.pop()
print(stack)
print(stack.peek())

print('Queue:')
queue = Queue([1, 2, 3])
print(queue)
print(queue.peek())
queue.dequeue()
print(queue)
print(queue.peek())



