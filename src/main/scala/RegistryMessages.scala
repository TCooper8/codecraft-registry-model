package codecraft.registry



final case class CmdRoute(
  urlPath: String,
  cmdKey: String
)

final case class Registry(
  id: String,
  active: Boolean,
  protocol: String,
  routes: List[CmdRoute],
  host: String,
  port: Int
)

final case class PostRegistry(
  active: Boolean,
  protocol: String,
  routes: List[CmdRoute],
  host: String,
  port: Int
)

final case class DeleteRegistry(
  id: String
)

final case class DeleteRegistryReply(
  code: Int,
  status: Option[String]
)

final case class PostRegistryReply(
  id: Option[String],
  code: Int,
  status: Option[String]
)

final case class GetRegistries(
  protocol: String,
  cmdKey: String
)

final case class GetRegistriesReply(
  registries: Option[List[Registry]],
  code: Int,
  status: Option[String]
)

final case class RegistryUpdated(
  id: String,
  registry: Registry,
  active: Boolean
)