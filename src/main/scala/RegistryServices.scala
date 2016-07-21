package codecraft.registry

import codecraft.codegen.CmdGroupConsumer

trait IRegistryStore extends CmdGroupConsumer {
  def delete(cmd: DeleteRegistry): DeleteRegistryReply
  def get(cmd: GetRegistries): GetRegistriesReply
  def put(cmd: PostRegistry): PostRegistryReply
  val methodRegistry = Map[String, Any => Any](
    "cmd.registry.delete" -> {
      any => delete(any.asInstanceOf[DeleteRegistry])
    },
    "cmd.registry.get" -> {
      any => get(any.asInstanceOf[GetRegistries])
    },
    "cmd.registry.put" -> {
      any => put(any.asInstanceOf[PostRegistry])
    }
  )
}