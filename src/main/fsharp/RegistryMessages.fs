namespace codecraft.registry



type CmdRoute = {
  urlPath: string
  cmdKey: string
}

type Registry = {
  id: string
  active: bool
  protocol: string
  routes: list<CmdRoute>
  host: string
  port: int
}

type PostRegistry = {
  active: bool
  protocol: string
  routes: list<CmdRoute>
  host: string
  port: int
}

type DeleteRegistry = {
  id: string
}

type DeleteRegistryReply = {
  code: int
  status: option<string>
}

type PostRegistryReply = {
  id: option<string>
  code: int
  status: option<string>
}

type GetRegistries = {
  protocol: string
  cmdKey: string
}

type GetRegistriesReply = {
  registries: option<list<Registry>>
  code: int
  status: option<string>
}

type RegistryUpdated = {
  id: string
  registry: Registry
  active: bool
}