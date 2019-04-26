vars_in_namespace = dict()
parents = dict()
vars_in_namespace['global'] = []
parents['global'] = None


def create(namespace, parent):
    vars_in_namespace[namespace] = []
    parents[namespace] = parent


def add(namespace, var):
    vars_in_namespace[namespace].append(var)


def get(namespace, var):
    if namespace is None:
        return None
    elif vars_in_namespace[namespace] is not None:
        if var in vars_in_namespace[namespace]:
            return namespace
        else:
            return get(parents[namespace], var)
    else:
        return get(parents[namespace], var)


def parser(string):
    commands = string.split()

    if commands[0] == 'create':
        create(*commands[1:])
    elif commands[0] == 'add':
        add(*commands[1:])
    elif commands[0] == 'get':
        print(get(*commands[1:]))
    else:
        print('There is no such command')


if __name__ == '__main__':
    n = int(input())
    for i in range(n):
        parser(input())
