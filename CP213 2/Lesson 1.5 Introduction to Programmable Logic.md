###### List three major categories of programmable logic devices and specify their acronyms.
	- SPLDs (Simple Programmable logic devices)
	- CPLDs (Complex Programmable logic devices)
	- FPGAs (Field Programmable Gate Array)

###### How does a CPLD differ from an SPLD?
	- CPLD is a device containing many SPLDs 
	- CPLD does the work of SPLD on a larger scale

###### Name the steps in the programming process.
	-Design Entry: The circuit or system design must be entered into the design application software using text-based entry, graphic entry (schematic capture), or state diagram description.Once a design has been entered, it is compiled. A compiler is a program that controls the design flow process and translates source code into object code in a format that can be logically tested or downloaded to a target device.
	-Functional Simulation: a waveform editor will verify that the correct outputs are produced for a specified set of inputs. this confirms the logic system circuit is functioning as expected
	-Synthesis:is where the design is translated into a netlist, which has a standard form and is device independent.
	-Implementation: this process also called fitting or place and route and results in an output called a bitstream  which is the result of the logic structures described by the netlist are mapped into the actual structure of the specific device being programmed.
	-Timing: The timing simulation is basically used to confirm that there are no design flaws or timing problems due to propagation delays.
	-Download: Once a bitstream has been generated for a specific programmable device, it has to be downloaded to the device to implement the software design in hardware.

###### What are the two main functional characteristics of a microcontroller?
	-The microcontroller has fixed internal circuits and its operation is directed by a program.
	