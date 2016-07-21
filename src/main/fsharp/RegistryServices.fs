namespace codecraft.registry

open codecraft.codegen

[<AbstractClass>]
type IRegistryStore () =
  inherit CmdGroupConsumer()
  override this.methodRegistry =   Map<string, obj -> obj> [
      ("cmd.registry.delete", fun (any: obj) -> this.delete(any :?> DeleteRegistry) :> obj)
      ("cmd.registry.get", fun (any: obj) -> this.get(any :?> GetRegistries) :> obj)
      ("cmd.registry.put", fun (any: obj) -> this.put(any :?> PostRegistry) :> obj)
    ]
  abstract member delete: DeleteRegistry -> DeleteRegistryReply
  abstract member get: GetRegistries -> GetRegistriesReply
  abstract member put: PostRegistry -> PostRegistryReply
