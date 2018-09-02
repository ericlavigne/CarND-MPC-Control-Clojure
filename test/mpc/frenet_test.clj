(ns mpc.frenet-test
  (:require [clojure.test :refer :all]
            [mpc.frenet :refer :all]
            same))

"""
Problems with jagged track and/or large d

mpc.core=> (require '[mpc.frenet :refer [track sd->xy xy->sd]])
nil
mpc.core=> (def t (track [[1 2] [2 1] [3 2] [4 1] [5 2]]))
#'mpc.core/t
mpc.core=> (sd->xy 2.9495853813618313 0)

ArityException Wrong number of args (2) passed to: frenet/sd->xy  clojure.lang.AFn.throwArity (AFn.java:429)
mpc.core=> (sd->xy t 2.9495853813618313 0)
[3.0856718248496597 1.9821147022704158]
mpc.core=> (xy->sd t 3.0856718248496597 1.9821147022704158)
s: 2.8284271247461903 -> 2.889006253054009
s: 2.889006253054009 -> 2.9197266424713657
s: 2.9197266424713657 -> 2.9350263443775537
s: 2.9273764934244597 -> 2.938789330299031
s: 2.9330829118617454 -> 2.9415822468415347
s: 2.9339328453597244 -> 2.9419971594925864
s: 2.9347392767730107 -> 2.942390572894202
s: 2.93550440638513 -> 2.9427635992605063
s: 2.9362303256726676 -> 2.9431172935429095
s: 2.936919022459692 -> 2.9434526563370564
s: 2.9375723858474285 -> 2.9437706366483094
x0:3.077396495517702 y0:1.9853251321349816 d:-2.959102222771556E-4 distance:0.008876256838761497
[2.9378822983874726 -0.008876256838761497]
mpc.core=> (sd->xy t 2.9378822983874726 -0.008876256838761497)
[3.077915079381223 1.991601593537223]
mpc.core=> (sd->xy t 2.9378822983874726 3.0)
[2.9021253627841315 -0.13599521142460258]
mpc.core=> (xy->sd t 2.9021253627841315 -0.13599521142460258)
s: 1.4142135623730951 -> 1.707871200779006
s: 1.707871200779006 -> 1.7113028184313808
s: 1.7113028184313808 -> 1.7116995460584243
s: 1.7115011822449024 -> 1.7117227914018818
s: 1.711611986823392 -> 1.7117357910028081
s: 1.7116243672413338 -> 1.7117372441387924
s: 1.7116356549310796 -> 1.711738569133595
s: 1.7116459463513312 -> 1.7117397772790182
s: 1.7116553294441 -> 1.7117408788731847
s: 1.7116638843870084 -> 1.7117418833077505
s: 1.7116716842790827 -> 1.711742799147504
x0:2.2103371694090237 y0:1.1703249871235486 d:-0.2300873046334186 distance:1.4781892184791758
[1.7116752400225037 -1.4781892184791758]
mpc.core=> (sd->xy t 1.7116752400225037 -1.4781892184791758)
[1.656887438304649 2.215562607387001]



Works fairly well with smooth track and small d

mpc.core=> (def t (track [[0 0] [1 2] [2 3.5] [3 4.5] [4 4.5] [5 4] [6 3] [7 2.7] [8 3.3] [9 4.6]]))
#'mpc.core/t
mpc.core=> (xy->sd t 6 3)
s: 8.98530472872787 -> 8.98530472872787
x0:6.0 y0:3.0 d:-0.0 distance:0.0
[8.98530472872787 -0.0]
mpc.core=> (sd->xy t 8.98530472872787 0)
[6.0 3.0]
mpc.core=> (sd->xy t 8.98530472872787 1.0)
[5.403057333950362 2.161593781470092]
mpc.core=> (xy->sd t 5.403057333950362 2.161593781470092)
s: 8.98530472872787 -> 8.98530472872787
x0:6.0 y0:3.0 d:0.856820989872288 distance:1.0292062639821375
[8.98530472872787 1.0292062639821375]
mpc.core=> (sd->xy t 8.98530472872787 -1.0)
[6.596942666049638 3.838406218529908]
mpc.core=> (xy->sd t 6.596942666049638 3.838406218529908)
s: 8.98530472872787 -> 8.98530472872787
x0:6.0 y0:3.0 d:-0.856820989872288 distance:1.0292062639821375
[8.98530472872787 -1.0292062639821375]
"""
