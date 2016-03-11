 <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Caches </h1>
                </div>
</div>
<div class="row" ngcontroller="cache">
     <div class="col-lg-3 col-md-6" ng-repeat="chd in cacheDetails">
         <div class="panel panel-primary">
             <div class="panel-heading">
                 <div class="row">
                     <div class="col-xs-9 text-right">
                         <div class="huge">{{chd.name}}</div>
                         <div>{{chd.description}}</div>
                     </div>
                 </div>
             </div>
             <a href="#/cacheDetails/{{chd.id}}">
                 <div class="panel-footer">
                     <span class="pull-left">View Data</span>
                     <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                     <div class="clearfix"></div>
                 </div>
             </a>
         </div>
     </div>           
</div>