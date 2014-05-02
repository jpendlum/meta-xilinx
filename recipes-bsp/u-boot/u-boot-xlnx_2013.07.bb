# Revision corresponds to commit after 2013.07 merge
# in u-boot-xlnx.git
SRCREV = "f40924452f947fbd6886eaa677c1b0bd47edfcf5"
PV = "v2013.07${XILINX_EXTENSION}"
PR = "r1"

ZYNQ_FSBL = "${WORKDIR}/fsbl-${MACHINE}.elf"
ZYNQ_UENV = "${WORKDIR}/uEnv-${MACHINE}.txt"
ZYNQ_BITFILE = "${WORKDIR}/${MACHINE}.bit"

include u-boot-xlnx.inc

SRC_URI_append += " \
    file://zynq_common-Add-uEnv.txt-boot-environment-load-suppo.patch \
	  file://zynq-Increase-number-of-arguments.patch \
	  file://${MACHINE}/fsbl-${MACHINE}.elf.bz2 \
    file://${MACHINE}/uEnv-${MACHINE}.txt.bz2 \
    file://${MACHINE}/${MACHINE}.bit.bz2 \
    "
