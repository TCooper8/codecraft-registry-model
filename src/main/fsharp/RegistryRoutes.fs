namespace codecraft.registry

open System
open System.Text
open Newtonsoft.Json
open codecraft.registry
open codecraft.codegen
open Newtonsoft.Json.Converters

module RegistryRoutingGroup =
  let enc = Encoding.UTF8
  let jsonSettings = new IdiomaticDuConverter()
  let groupRouting = {
    queueName = "cmd.registry"
    routingKey = "cmd.registry.*"
    exchange = "cmd"
  }
  let cmdInfo = [
    {
      key = "cmd.registry.delete";
      serializeCmd = fun (any: obj) -> (
        try JsonConvert.SerializeObject(any :?> DeleteRegistry, jsonSettings) |> enc.GetBytes |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      serializeReply = fun (any: obj) -> (
        try JsonConvert.SerializeObject(any :?> DeleteRegistryReply, jsonSettings) |> enc.GetBytes |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      deserializeCmd = fun (bytes: byte array) -> (
        try
          let data = bytes |> enc.GetString
          JsonConvert.DeserializeObject<DeleteRegistry>(data, jsonSettings) :> obj |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      deserializeReply = fun (bytes: byte array) -> (
        try
          let data = bytes |> enc.GetString
          JsonConvert.DeserializeObject<DeleteRegistryReply>(data, jsonSettings) :> obj |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      group = groupRouting;
    };
    {
      key = "cmd.registry.get";
      serializeCmd = fun (any: obj) -> (
        try JsonConvert.SerializeObject(any :?> GetRegistries, jsonSettings) |> enc.GetBytes |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      serializeReply = fun (any: obj) -> (
        try JsonConvert.SerializeObject(any :?> GetRegistriesReply, jsonSettings) |> enc.GetBytes |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      deserializeCmd = fun (bytes: byte array) -> (
        try
          let data = bytes |> enc.GetString
          JsonConvert.DeserializeObject<GetRegistries>(data, jsonSettings) :> obj |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      deserializeReply = fun (bytes: byte array) -> (
        try
          let data = bytes |> enc.GetString
          JsonConvert.DeserializeObject<GetRegistriesReply>(data, jsonSettings) :> obj |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      group = groupRouting;
    };
    {
      key = "cmd.registry.put";
      serializeCmd = fun (any: obj) -> (
        try JsonConvert.SerializeObject(any :?> PostRegistry, jsonSettings) |> enc.GetBytes |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      serializeReply = fun (any: obj) -> (
        try JsonConvert.SerializeObject(any :?> PostRegistryReply, jsonSettings) |> enc.GetBytes |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      deserializeCmd = fun (bytes: byte array) -> (
        try
          let data = bytes |> enc.GetString
          JsonConvert.DeserializeObject<PostRegistry>(data, jsonSettings) :> obj |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      deserializeReply = fun (bytes: byte array) -> (
        try
          let data = bytes |> enc.GetString
          JsonConvert.DeserializeObject<PostRegistryReply>(data, jsonSettings) :> obj |> Choice1Of2
        with e -> e |> Choice2Of2
      );
      group = groupRouting;
    }
  ]