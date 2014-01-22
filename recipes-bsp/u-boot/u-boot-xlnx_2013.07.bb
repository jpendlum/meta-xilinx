# Revision corresponds to commit after 2013.07 merge
# in u-boot-xlnx.git
SRCREV = "f40924452f947fbd6886eaa677c1b0bd47edfcf5"
PV = "v2013.07${XILINX_EXTENSION}"
PR = "r1"

SRC_URI_append_zedboard-zynq7 = " file://fsbl.elf.bz2 \
                                  file://uEnv.txt-sd-boot \
                                "

ZYNQ_FSBL = "${WORKDIR}/fsbl.elf"

include u-boot-xlnx.inc

SRC_URI_append += " \
		file://zynq_common-Add-uEnv.txt-boot-environment-load-suppo.patch \
		file://zynq-Increase-number-of-arguments.patch \
		"
