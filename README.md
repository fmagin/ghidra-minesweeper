# Minesweeper Minigame for Ghidra

Rumor goes that Ghidra is short for ["Go Home, Initial Disassembly Runs for an Afternoon"](https://twitter.com/evm_sec/status/1099337477356167168),
and just decompiling large functions can take already take ages. 

This plugin allows you to distract yourself during those times, while still making it look like you are working.



## Installation

### Prebuilt

Ready to install builds are compiled via GitHub Actions and available as [releases](./releases/latest)

### Development

Regular Ghidra Extension build process:

```sh
gradle -PGHIDRA_INSTALL_DIR=/path/to/ghidra buildExtension
```