package codecraft.registry

import play.api.libs.json._
import codecraft.registry._
import codecraft.codegen._
import scala.util.Try

object RegistryFormatters {
  implicit val CmdRouteFormat = Json.format[CmdRoute]
  implicit val RegistryFormat = Json.format[Registry]
  implicit val PostRegistryFormat = Json.format[PostRegistry]
  implicit val DeleteRegistryFormat = Json.format[DeleteRegistry]
  implicit val DeleteRegistryReplyFormat = Json.format[DeleteRegistryReply]
  implicit val PostRegistryReplyFormat = Json.format[PostRegistryReply]
  implicit val GetRegistriesFormat = Json.format[GetRegistries]
  implicit val GetRegistriesReplyFormat = Json.format[GetRegistriesReply]
  implicit val RegistryUpdatedFormat = Json.format[RegistryUpdated]
}

object RegistryRoutingGroup {
  import RegistryFormatters._
  val groupRouting = GroupRouting(
    "cmd.registry",
    "cmd.registry.*",
    "cmd"
  )
  lazy val cmdInfo = List(
    codecraft.codegen.CmdRegistry(
      "cmd.registry.delete",
      (any: Any) => Try {
        val value = any.asInstanceOf[DeleteRegistry]
        Json.toJson(value).toString.getBytes
      },
      (any: Any) => Try {
        val value = any.asInstanceOf[DeleteRegistryReply]
        Json.toJson(value).toString.getBytes
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[DeleteRegistry](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[DeleteRegistry]
        }
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[DeleteRegistryReply](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[DeleteRegistryReply]
        }
      },
      groupRouting
    ),
    codecraft.codegen.CmdRegistry(
      "cmd.registry.get",
      (any: Any) => Try {
        val value = any.asInstanceOf[GetRegistries]
        Json.toJson(value).toString.getBytes
      },
      (any: Any) => Try {
        val value = any.asInstanceOf[GetRegistriesReply]
        Json.toJson(value).toString.getBytes
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[GetRegistries](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[GetRegistries]
        }
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[GetRegistriesReply](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[GetRegistriesReply]
        }
      },
      groupRouting
    ),
    codecraft.codegen.CmdRegistry(
      "cmd.registry.put",
      (any: Any) => Try {
        val value = any.asInstanceOf[PostRegistry]
        Json.toJson(value).toString.getBytes
      },
      (any: Any) => Try {
        val value = any.asInstanceOf[PostRegistryReply]
        Json.toJson(value).toString.getBytes
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[PostRegistry](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[PostRegistry]
        }
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[PostRegistryReply](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[PostRegistryReply]
        }
      },
      groupRouting
    )
  )
}

object RegistryRoutingInfo {
  import RegistryFormatters._
  val eventInfo: List[EventRegistry] = List(
    EventRegistry(
      "event.registry.updated",
      "event",
      (any: Any) => Try {
        val value = any.asInstanceOf[RegistryUpdated]
        Json.toJson(value).toString.getBytes
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[RegistryUpdated](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[RegistryUpdated]
        }
      }
    )
  )
}