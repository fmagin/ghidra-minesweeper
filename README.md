# Minesweeper Minigame for Ghidra

Rumor goes that Ghidra is short for ["Go Home, Initial Disassembly Runs for an Afternoon"](https://twitter.com/evm_sec/status/1099337477356167168),
and just decompiling large functions can take already take ages. 

This plugin allows you to distract yourself during those times, while still making it look like you are working.

![](./imgs/minesweeper_demo.png)


## Installation

### Prebuilt

Ready to install builds are compiled via GitHub Actions and available as [releases](../../releases/latest)

### Development

Regular Ghidra Extension build process:

```sh
gradle -PGHIDRA_INSTALL_DIR=/path/to/ghidra buildExtension
```


## Attribution

### Icons 

<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>


### Minesweeper Game Code

Based on https://github.com/jahed/swing-minesweeper with some minor modifications
```

Copyright (C) 2010 Jahed Ahmed

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```